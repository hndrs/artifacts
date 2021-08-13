package io.hndrs.artifacts

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.Tag
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.DocumentationType.OAS_30
import springfox.documentation.spi.service.OperationBuilderPlugin
import springfox.documentation.spi.service.contexts.OperationContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger.common.SwaggerPluginSupport

@Configuration
class OpenApiConfiguration {


    @Bean
    fun docket(): Docket = Docket(OAS_30)
        .tags(Tag("Artifacts Api", "analysis description"))
        .select()
        .apis(RequestHandlerSelectors.basePackage("io.hndrs"))
        .build()
}

@Component
@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 1)
class GlobalTag : OperationBuilderPlugin {
    override fun supports(delimiter: DocumentationType): Boolean {
        return delimiter == OAS_30
    }

    override fun apply(context: OperationContext) {
        context.operationBuilder().tags(setOf("Artifacts Api"))
    }

}
