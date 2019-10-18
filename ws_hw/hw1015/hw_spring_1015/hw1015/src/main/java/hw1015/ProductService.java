package hw1015;

import java.util.List;

public interface ProductService {
	ProductRepo getRepo();

	List<Product> selectAll();

	Product select(String id);

	int insert(Product product);

	int update(Product product);

	int delete(String id);

}
