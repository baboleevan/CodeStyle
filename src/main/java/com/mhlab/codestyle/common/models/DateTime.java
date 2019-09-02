package com.mhlab.codestyle.common.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

/**
 * Created by mhlab(dex) on 2019-05-20.
 */

@Embeddable
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class DateTime {

    @CreatedDate
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "mod_date")
    private LocalDateTime modDate;

    @PrePersist
    public void prePersist() {
        this.createDate = LocalDateTime.now();
        this.modDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.modDate = LocalDateTime.now();
    }

}
