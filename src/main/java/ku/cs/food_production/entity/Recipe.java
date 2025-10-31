package ku.cs.food_production.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_id")
    private List<RecipeItem> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<RecipeItem> getItems() {
        return items;
    }

    public void setItems(List<RecipeItem> items) {
        this.items = items;
    }
}
