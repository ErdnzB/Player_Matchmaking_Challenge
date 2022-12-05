package com.bestseller.gaming.persistence.entity;


import com.bestseller.gaming.enums.PlayerLevels;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "player",
        uniqueConstraints = {
                @UniqueConstraint(name = "UC_NAME_GAME_REGION", columnNames = {"name", "game_id", "region_id"}),
                @UniqueConstraint(name = "UC_NAME_GAME", columnNames = {"name", "game_id"})
        })
@EntityListeners(AuditingEntityListener.class)
public class PlayerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private GameEntity game;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private RegionEntity region;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private PlayerLevels playerLevel;

}
