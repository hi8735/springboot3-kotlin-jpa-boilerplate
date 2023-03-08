package com.example.springboot3.configuration

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class SpringDocConfig {
    @Bean
    fun publicApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("springshop-public")
            .pathsToMatch("/public/**")
            .build()
    }

    @Bean
    fun defaultApi(): GroupedOpenApi? {
        return GroupedOpenApi.builder()
            .group("springboot3")
            .pathsToMatch("/")
            .build()
    }

    @Bean
    fun springShopOpenAPI(): OpenAPI? {
        return OpenAPI()
            .info(
                Info().title("SpringBoot3 User API")
                    .description("User sample application")
                    .version("v0.0.1")
            )
    }

//    @ApiModel(description = "페이지 요청")
//    data class Page(
//        @ApiModelProperty(value = "페이지 번호", example = "0")
//        val page: Int,
//
//        @ApiModelProperty(value = "\${sfn.swagger.size.value}", example = "50")
//        val size: Int,
//
//        @ApiModelProperty(value = "정렬 (사용법: 컬럼명,ASC|DESC) ex> id,DESC", example = "id,DESC")
//        val sort: List<String>,
//    )
}



@Configuration
class WebMvcConfig(
) : WebMvcConfigurer {
    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/swagger-ui/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
            .resourceChain(false)
    }

}
