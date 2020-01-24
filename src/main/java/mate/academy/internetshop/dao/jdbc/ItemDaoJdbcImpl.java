package mate.academy.internetshop.dao.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mate.academy.internetshop.dao.ItemDao;
import mate.academy.internetshop.lib.Dao;
import mate.academy.internetshop.model.Item;
import org.apache.log4j.Logger;

@Dao
public class ItemDaoJdbcImpl extends AbstractDao<Item> implements ItemDao {

    private static String DB_NAME = "test.items";
    private static Logger logger = Logger.getLogger(ItemDaoJdbcImpl.DB_NAME);

    public ItemDaoJdbcImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        String query = String.format("SELECT * FROM %s", DB_NAME);

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Item item = new Item(rs.getString("name"),
                        rs.getDouble("price"));
                item.setId(rs.getLong("item_id"));
                list.add(item);
            }
        } catch (SQLException e) {
            logger.warn("Can't get items");
            logger.warn("Exception was", e);
        }
        return list;
    }

    @Override
    public Item create(Item item) {
        String name = item.getName();
        Double price = item.getPrice();
        String query = String.format("INSERT INTO %s (name,price) VALUES ('%s',%f);",
                DB_NAME, name, price);
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            logger.error("Item can't be added", e);
        }

        return item;
    }

    @Override
    public Item get(Long id) {
        String query = String.format(" SELECT * FROM %s items WHERE item_id=%o",
                DB_NAME, id);
        try (Statement stmt = connection.createStatement();) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                long itemId = rs.getLong("item_id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                Item item = new Item(itemId);
                item.setName(name);
                item.setPrice(price);
                return item;
            }

        } catch (SQLException e) {
            logger.warn("Can't get item by id " + id);
        }
        return null;
    }

    @Override
    public Item update(Item item) {
        Long id = item.getId();
        String name = item.getName();
        Double price = item.getPrice();
        String query = String.format("UPDATE %s set name = '%s', price = %f WHERE item_id = %o;",
                DB_NAME, name, price, id);
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            logger.warn("Item couldn't be update", e);
        }
        return item;
    }

    @Override
    public boolean deleteById(Long id) {
        String query = String.format("DELETE FROM %s WHERE item_id =%o;", DB_NAME, id);
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            logger.warn("Can't delete item with id " + id);
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Item item) {
        return false;
    }
}
