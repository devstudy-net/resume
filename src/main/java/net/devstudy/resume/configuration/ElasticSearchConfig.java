package net.devstudy.resume.configuration;

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories("net.devstudy.resume.repository.search")
public class ElasticSearchConfig {
	
	@Value("${elasticsearch.home}")
	private String elasticSearchHome;
	
	/**
	 * http://docs.spring.io/autorepo/docs/spring/4.2.5.RELEASE/spring-framework-reference/html/beans.html
	 * 
	 * By default, beans defined using Java config that have a public close or shutdown method are automatically enlisted with a destruction callback.
	 */
	@Bean(/*destroyMethod="close"*/)
	public Node node(){
		return new NodeBuilder()
				.local(true)
				.settings(Settings.builder().put("path.home", elasticSearchHome))
				.node();
	}
	
	@Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(node().client());
    }
}
