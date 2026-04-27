-- =============================================================
-- NutriBalance Sample Data
-- Passwords are BCrypt hashes of "Password123!"
-- =============================================================

-- -------------------------------------------------------------
-- Users (1 ADMIN, 1 DOCTOR, 1 PARENT, 2 CHILD)
-- BCrypt hash for "Password123!"
-- -------------------------------------------------------------
INSERT IGNORE INTO user (id, full_name, organization_name, email, password, role) VALUES
(1, 'Alice Admin',    'NutriBalance HQ',      'alice.admin@nutribalance.com',  '$2a$10$7QJ8zV3kL9mN2pR5sT1uOeWxYbCdEfGhIjKlMnOpQrStUvWxYzAb12', 'ADMIN'),
(2, 'Dr. Ben Carter', 'City Health Clinic',   'ben.carter@cityhealth.com',     '$2a$10$7QJ8zV3kL9mN2pR5sT1uOeWxYbCdEfGhIjKlMnOpQrStUvWxYzAb12', 'DOCTOR'),
(3, 'Carol Nguyen',   'Nguyen Family',        'carol.nguyen@email.com',        '$2a$10$7QJ8zV3kL9mN2pR5sT1uOeWxYbCdEfGhIjKlMnOpQrStUvWxYzAb12', 'PARENT'),
(4, 'Danny Nguyen',   'Nguyen Family',        'danny.nguyen@email.com',        '$2a$10$7QJ8zV3kL9mN2pR5sT1uOeWxYbCdEfGhIjKlMnOpQrStUvWxYzAb12', 'CHILD'),
(5, 'Emma Nguyen',    'Nguyen Family',        'emma.nguyen@email.com',         '$2a$10$7QJ8zV3kL9mN2pR5sT1uOeWxYbCdEfGhIjKlMnOpQrStUvWxYzAb12', 'CHILD');

-- -------------------------------------------------------------
-- Diet Entries (10 entries spread across the last 7 days)
-- -------------------------------------------------------------
INSERT IGNORE INTO diet_entries (id, food_name, calories, protein, carbs, fats, date, user_id) VALUES
(1,  'Oatmeal with Berries',      320,  8,  58,  6,  CURDATE() - INTERVAL 6 DAY, 4),
(2,  'Grilled Chicken Breast',    250, 46,   0,  5,  CURDATE() - INTERVAL 6 DAY, 4),
(3,  'Steamed White Rice',        206,  4,  45,  0,  CURDATE() - INTERVAL 5 DAY, 4),
(4,  'Garden Salad with Tuna',    180, 22,  10,  5,  CURDATE() - INTERVAL 5 DAY, 5),
(5,  'Apple',                      95,  0,  25,  0,  CURDATE() - INTERVAL 4 DAY, 5),
(6,  'Whole Wheat Bread (2 slices)', 160, 6, 30,  2,  CURDATE() - INTERVAL 4 DAY, 3),
(7,  'Scrambled Eggs (2 eggs)',   180, 12,   2, 13,  CURDATE() - INTERVAL 3 DAY, 3),
(8,  'Banana',                    105,  1,  27,  0,  CURDATE() - INTERVAL 3 DAY, 4),
(9,  'Lentil Soup',               230, 18,  40,  1,  CURDATE() - INTERVAL 2 DAY, 5),
(10, 'Greek Yogurt with Honey',   150, 10,  20,  3,  CURDATE() - INTERVAL 1 DAY, 4);

-- -------------------------------------------------------------
-- Chat Messages (8 messages about nutrition/health)
-- -------------------------------------------------------------
INSERT IGNORE INTO chat_message (id, sender, content, timestamp) VALUES
(1, 'Dr. Ben Carter', 'Good morning! How is Danny feeling after starting the new meal plan?',                                    NOW() - INTERVAL 6 DAY),
(2, 'Carol Nguyen',   'He seems more energetic! He finished his breakfast without any fuss today.',                              NOW() - INTERVAL 6 DAY + INTERVAL 10 MINUTE),
(3, 'Dr. Ben Carter', 'That is great to hear. Make sure he is drinking at least 6 glasses of water daily.',                     NOW() - INTERVAL 5 DAY),
(4, 'Carol Nguyen',   'Will do. Emma has been asking about healthy snack options between meals.',                                NOW() - INTERVAL 5 DAY + INTERVAL 15 MINUTE),
(5, 'Dr. Ben Carter', 'Fruits like apples or bananas are perfect. You can also try carrot sticks with hummus.',                 NOW() - INTERVAL 4 DAY),
(6, 'Danny Nguyen',   'Doctor, I tried the lentil soup recipe you suggested. It was really good!',                              NOW() - INTERVAL 2 DAY),
(7, 'Dr. Ben Carter', 'Wonderful, Danny! Lentils are packed with protein and fibre — great for growing kids.',                  NOW() - INTERVAL 2 DAY + INTERVAL 5 MINUTE),
(8, 'Carol Nguyen',   'Thank you for all your guidance, Doctor. The kids are really enjoying the healthier meals.',             NOW() - INTERVAL 1 DAY);

-- -------------------------------------------------------------
-- Education Content (6 educational videos)
-- -------------------------------------------------------------
INSERT IGNORE INTO education_content (id, title, description, youtube_url, reward_points) VALUES
(1, 'Understanding Macronutrients',
    'Learn about proteins, carbohydrates, and fats — what they are, why your body needs them, and how to balance them in your daily diet.',
    'https://www.youtube.com/watch?v=HnFPEkBKBk8',
    20),
(2, 'Healthy Eating for Kids',
    'A fun and engaging guide for children on building balanced meals, choosing nutritious snacks, and developing lifelong healthy eating habits.',
    'https://www.youtube.com/watch?v=YbYbjyT5jt4',
    15),
(3, 'The Importance of Hydration',
    'Discover how staying properly hydrated affects energy levels, concentration, digestion, and overall health for both children and adults.',
    'https://www.youtube.com/watch?v=9iMGFqMmUFs',
    10),
(4, 'Introduction to Vitamins and Minerals',
    'An overview of essential vitamins and minerals, the foods that contain them, and the role they play in keeping your body strong and healthy.',
    'https://www.youtube.com/watch?v=oBzCBZFpMgE',
    25),
(5, 'Building Healthy Exercise Habits',
    'Practical tips for incorporating regular physical activity into a busy family schedule, with age-appropriate exercises for children.',
    'https://www.youtube.com/watch?v=Ks-_Mh1QhMc',
    30),
(6, 'Reading Food Labels',
    'A step-by-step guide to understanding nutrition labels on packaged foods so you can make informed choices at the supermarket.',
    'https://www.youtube.com/watch?v=9XMnkfX1Ixo',
    50);

-- -------------------------------------------------------------
-- Recommendations (5 from doctor to patients)
-- -------------------------------------------------------------
INSERT IGNORE INTO recommendation (id, patient_id, doctor_id, category, notes, timestamp) VALUES
(1, 4, 2, 'Diet',
    'Danny should aim for 5 servings of fruits and vegetables per day. Focus on colourful produce to ensure a wide range of vitamins and minerals. Reduce processed snacks and sugary drinks.',
    NOW() - INTERVAL 6 DAY),
(2, 5, 2, 'Diet',
    'Emma needs to increase her iron intake. Include iron-rich foods such as lean red meat, spinach, and fortified cereals at least 3 times per week. Pair with vitamin C sources to improve absorption.',
    NOW() - INTERVAL 5 DAY),
(3, 4, 2, 'Exercise',
    'Danny should engage in at least 60 minutes of moderate physical activity daily. Encourage outdoor play, cycling, or swimming. Limit screen time to no more than 2 hours per day.',
    NOW() - INTERVAL 4 DAY),
(4, 5, 2, 'Health',
    'Emma''s recent check-up shows slightly low vitamin D levels. Recommend 15–20 minutes of outdoor sunlight exposure daily and consider a vitamin D supplement after consulting with a pharmacist.',
    NOW() - INTERVAL 3 DAY),
(5, 3, 2, 'Diet',
    'Carol should model healthy eating behaviours for the children. Suggest family meals at the table without screens, and involve the kids in meal preparation to build positive relationships with food.',
    NOW() - INTERVAL 1 DAY);
