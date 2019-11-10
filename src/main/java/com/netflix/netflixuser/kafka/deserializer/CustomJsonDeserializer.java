package com.netflix.netflixuser.kafka.deserializer;

import org.springframework.kafka.support.serializer.JsonDeserializer;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 10/11/2019 18:58
 */
public class CustomJsonDeserializer<T> extends JsonDeserializer<T> {
    public CustomJsonDeserializer(Class<? super T> targetType) {
        super(targetType);
        this.addTrustedPackages("*");
    }
}
