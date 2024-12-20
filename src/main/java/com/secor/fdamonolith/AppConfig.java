package com.secor.fdamonolith;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{

        @Bean
        public Credential DummyCredential()
        {
            Credential credential =  new Credential();
            credential.setUsername("dummy");
            credential.setPassword("test@dummy");

            return credential;
        }

    @Bean
    public Credential AnotherDummyCredential()
    {
        Credential credential =  new Credential();
        credential.setUsername("johndoe");
        credential.setPassword("doe@12345");

        return credential;
    }

}
