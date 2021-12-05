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
@Entity(name = "paragraphs")
public class ParagraphEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "paragraph_num")
    private int paragraph_num;

    @Column(name = "plain_text")
    private String plain_text;

    @Column(name = "chracater_id")
    private int chracater_id;

    @Column(name = "chapter_id")
    private int chapter_id;
}
