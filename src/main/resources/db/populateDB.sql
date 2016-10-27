DELETE FROM restaurants;
DELETE FROM meals;
DELETE FROM users;
DELETE FROM user_roles;
ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO users (name, email, password) VALUES
  ('Admin', 'admin@gmail.com', 'admin'),
  ('User', 'user@gmail.com', 'password');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_ADMIN', 1),
  ('ROLE_USER', 2),
  ('ROLE_USER', 1);

INSERT INTO restaurants (name) VALUES
  ('McDonalds'),
  ('Burger King'),
  ('Subway');

INSERT INTO meals (name, price, restaurant_id) VALUES
  ('Big Mac', '3.99', 3),
  ('French Fries Medium', '1.69', 3),
  ('Soft Baked Chocolate Chip Cookie 3 Pc.', '1.00', 3),
  ('Orange Juice Medium', '1.89', 3),
  ('Big King', '3.89', 4),
  ('Chicken Nuggets 4 Pc.', '1.19', 4),
  ('French Toast Sticks 5 Pc.', '1.99', 4),
  ('Iced Tea (Sweet or Unsweetened) Medium', '2.09', 4),
  ('Pizza Sub with Cheese', '3.75', 5),
  ('Loaded Baked Potato with Bacon', '2.50', 5),
  ('Apple Slices', '1.50', 5),
  ('Coffee 16 oz.', '1.80', 5);
