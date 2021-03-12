package br.com.guilherme.serialization.converter;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class yamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter{

	public yamlJackson2HttpMessageConverter() {
		super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
	}
}
