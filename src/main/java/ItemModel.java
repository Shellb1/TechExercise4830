import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "GroceryList")
public class ItemModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "store")
	private String store;
	
	@Column(name = "item")
	private String item;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "category")
	private String category;

	public ItemModel() {
		
	}
	
	public ItemModel(Integer id, String store, String item, Integer quantity, String category) {
		this.id = id;
		this.store = store;
		this.item = item;
		this.quantity = quantity;
		this.category = category;
	}
	
	public ItemModel(String store, String item, Integer quantity, String category) {
		this.store = store;
		this.item = item;
		this.quantity = quantity;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "" + quantity + " of " + item + " of category " + category + " at store " + store;
	}
}
