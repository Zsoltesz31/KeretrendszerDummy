package hu.uni.eku.tzs.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "chapters")
public class ChapterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "act")
    private int act;

    @Column(name = "scene")
    private int scene;

    @Column(name = "description")
    private String description;

    @Column(name="work_id")
    private int work_id;
}
