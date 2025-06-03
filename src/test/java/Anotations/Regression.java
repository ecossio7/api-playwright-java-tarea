package Anotations;

import org.junit.jupiter.api.Tag;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Tag("regression")
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Regression {
}
