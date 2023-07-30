package com.application.library.mapper;

import org.mapstruct.*;

@MapperConfig(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR,
unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BaseConfig {

}
