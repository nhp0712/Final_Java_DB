package com.kits.quanlybenhvien.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class KhamKey {
    @Column(name = "MaBK")
    Integer maBK;
    @Column(name = "MaBSKham")
    String maBSKham;
    @Column(name = " MaBN")
    String maBN;
}
