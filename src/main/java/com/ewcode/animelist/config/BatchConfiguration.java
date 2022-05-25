package com.ewcode.animelist.config;

import com.ewcode.animelist.anime.dtos.AnimeCsvDto;
import com.ewcode.animelist.anime.entities.Anime;
import com.ewcode.animelist.anime.processors.AnimeSaveCsvProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor("spring_batch");
    }

    @Bean
    public FlatFileItemReader<AnimeCsvDto> reader() {
        return new FlatFileItemReaderBuilder<AnimeCsvDto>()
                .name("animeReader")
                .resource(new ClassPathResource("anime.csv"))
                .delimited()
                .names("anime_id", "name", "genre", "type", "episodes", "rating", "members")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(AnimeCsvDto.class);
                }})
                .build();
    }

    @Bean
    public AnimeSaveCsvProcessor processor() {
        return new AnimeSaveCsvProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Anime> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Anime>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO anime (name, episodes, type, genre, rating) " +
                        "VALUES (:name,:episodes, :type, :genre, :rating)") // UPDATE
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(Step step1) {
        return jobBuilderFactory.get("importAnimeJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Anime> writer) {
        return stepBuilderFactory.get("importAnimeStep")
                .<AnimeCsvDto, Anime>chunk(1000)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .taskExecutor(taskExecutor())
                .build();
    }
}
