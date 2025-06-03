package Anotations;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Tag("smoke")
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Smoke {
}
