package ee.karl_reimond.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
public class Category {
    @Id
    private Long id;

    private String name;
    private CategoryType categoryType;
}

enum CategoryType {
    PREMIUM, DELUXE, BASIC
}