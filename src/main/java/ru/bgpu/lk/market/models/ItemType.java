package ru.bgpu.lk.market.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ItemType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String string;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemType")
    private List<Item> items = new ArrayList<>();

    public ItemType() {
    }

    public ItemType(String string) {
        this.string = string;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
