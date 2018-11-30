package web.travelboard.model;

import javax.persistence.*;

@Entity
@Table(name = "tours")
public class Tour {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private static int id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private int date;

    @Column(name = "price")
    private int price;

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
