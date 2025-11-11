-- ===========================================
-- V2__insert_dummy_data.sql
-- Dummy data for testing
-- ===========================================

-- ========================
-- USERS
-- ========================
-- Teachers
INSERT INTO users (id, first_name, last_name, email) VALUES
                                                         ('550e8400-e29b-41d4-a716-446655440000', 'Carol', 'Williams', 'carol.williams@example.com'),
                                                         ('550e8400-e29b-41d4-a716-446655440001', 'David', 'Brown', 'david.brown@example.com'),
                                                         ('550e8400-e29b-41d4-a716-446655440002', 'Emma', 'Davis', 'emma.davis@example.com'),
                                                         ('550e8400-e29b-41d4-a716-446655440003', 'Frank', 'Miller', 'frank.miller@example.com'),
                                                         ('550e8400-e29b-41d4-a716-446655440004', 'Grace', 'Wilson', 'grace.wilson@example.com');

-- Students
INSERT INTO users (id, first_name, last_name, email) VALUES
                                                         ('6fa85f64-5717-4562-b3fc-2c963f66afa0', 'Alice', 'Johnson', 'alice.johnson@example.com'),
                                                         ('6fa85f64-5717-4562-b3fc-2c963f66afa1', 'Bob', 'Smith', 'bob.smith@example.com'),
                                                         ('6fa85f64-5717-4562-b3fc-2c963f66afa2', 'Henry', 'Moore', 'henry.moore@example.com'),
                                                         ('6fa85f64-5717-4562-b3fc-2c963f66afa3', 'Isabel', 'Taylor', 'isabel.taylor@example.com'),
                                                         ('6fa85f64-5717-4562-b3fc-2c963f66afa4', 'Jack', 'Anderson', 'jack.anderson@example.com'),
                                                         ('6fa85f64-5717-4562-b3fc-2c963f66afa5', 'Liam', 'Thomas', 'liam.thomas@example.com'),
                                                         ('6fa85f64-5717-4562-b3fc-2c963f66afa6', 'Mia', 'Martin', 'mia.martin@example.com'),
                                                         ('6fa85f64-5717-4562-b3fc-2c963f66afa7', 'Noah', 'Lee', 'noah.lee@example.com'),
                                                         ('6fa85f64-5717-4562-b3fc-2c963f66afa8', 'Olivia', 'Walker', 'olivia.walker@example.com'),
                                                         ('6fa85f64-5717-4562-b3fc-2c963f66afa9', 'Peter', 'Hall', 'peter.hall@example.com');

-- ========================
-- TEACHERS
-- ========================
INSERT INTO teachers (id, hire_date) VALUES
                                         ('550e8400-e29b-41d4-a716-446655440000', NOW() - INTERVAL '3 years'),
                                         ('550e8400-e29b-41d4-a716-446655440001', NOW() - INTERVAL '2 years'),
                                         ('550e8400-e29b-41d4-a716-446655440002', NOW() - INTERVAL '1 year'),
                                         ('550e8400-e29b-41d4-a716-446655440003', NOW() - INTERVAL '6 months'),
                                         ('550e8400-e29b-41d4-a716-446655440004', NOW() - INTERVAL '4 years');

-- ========================
-- STUDENTS
-- ========================
INSERT INTO students (id, enrollment_date) VALUES
                                               ('6fa85f64-5717-4562-b3fc-2c963f66afa0', NOW() - INTERVAL '1 year'),
                                               ('6fa85f64-5717-4562-b3fc-2c963f66afa1', NOW() - INTERVAL '6 months'),
                                               ('6fa85f64-5717-4562-b3fc-2c963f66afa2', NOW() - INTERVAL '3 months'),
                                               ('6fa85f64-5717-4562-b3fc-2c963f66afa3', NOW() - INTERVAL '2 months'),
                                               ('6fa85f64-5717-4562-b3fc-2c963f66afa4', NOW() - INTERVAL '5 months'),
                                               ('6fa85f64-5717-4562-b3fc-2c963f66afa5', NOW() - INTERVAL '4 months'),
                                               ('6fa85f64-5717-4562-b3fc-2c963f66afa6', NOW() - INTERVAL '3 weeks'),
                                               ('6fa85f64-5717-4562-b3fc-2c963f66afa7', NOW() - INTERVAL '2 weeks'),
                                               ('6fa85f64-5717-4562-b3fc-2c963f66afa8', NOW() - INTERVAL '1 week'),
                                               ('6fa85f64-5717-4562-b3fc-2c963f66afa9', NOW() - INTERVAL '5 days');

-- ========================
-- COURSES
-- ========================
INSERT INTO courses (id, title, teacher_id) VALUES
                                                ('3fa85f64-5717-4562-b3fc-2c963f66af00', 'Math 101', '550e8400-e29b-41d4-a716-446655440000'),
                                                ('3fa85f64-5717-4562-b3fc-2c963f66af01', 'Physics 101', '550e8400-e29b-41d4-a716-446655440001'),
                                                ('3fa85f64-5717-4562-b3fc-2c963f66af02', 'Chemistry 101', '550e8400-e29b-41d4-a716-446655440002'),
                                                ('3fa85f64-5717-4562-b3fc-2c963f66af03', 'Biology 101', '550e8400-e29b-41d4-a716-446655440003'),
                                                ('3fa85f64-5717-4562-b3fc-2c963f66af04', 'History 101', '550e8400-e29b-41d4-a716-446655440004');

-- ========================
-- STUDENT COURSES
-- ========================
INSERT INTO student_courses (student_id, course_id) VALUES
                                                        ('6fa85f64-5717-4562-b3fc-2c963f66afa0', '3fa85f64-5717-4562-b3fc-2c963f66af00'),
                                                        ('6fa85f64-5717-4562-b3fc-2c963f66afa1', '3fa85f64-5717-4562-b3fc-2c963f66af00'),
                                                        ('6fa85f64-5717-4562-b3fc-2c963f66afa2', '3fa85f64-5717-4562-b3fc-2c963f66af01'),
                                                        ('6fa85f64-5717-4562-b3fc-2c963f66afa3', '3fa85f64-5717-4562-b3fc-2c963f66af01'),
                                                        ('6fa85f64-5717-4562-b3fc-2c963f66afa4', '3fa85f64-5717-4562-b3fc-2c963f66af02'),
                                                        ('6fa85f64-5717-4562-b3fc-2c963f66afa5', '3fa85f64-5717-4562-b3fc-2c963f66af02'),
                                                        ('6fa85f64-5717-4562-b3fc-2c963f66afa6', '3fa85f64-5717-4562-b3fc-2c963f66af03'),
                                                        ('6fa85f64-5717-4562-b3fc-2c963f66afa7', '3fa85f64-5717-4562-b3fc-2c963f66af03'),
                                                        ('6fa85f64-5717-4562-b3fc-2c963f66afa8', '3fa85f64-5717-4562-b3fc-2c963f66af04'),
                                                        ('6fa85f64-5717-4562-b3fc-2c963f66afa9', '3fa85f64-5717-4562-b3fc-2c963f66af04');

-- ========================
-- REVIEWS
-- ========================
-- is_urgent = true if rating <= 2
INSERT INTO reviews (id, course_id, student_id, rating, comment, is_urgent, created_at) VALUES
                                                                                            ('1c6e2a7c-91f8-4eb3-9c3f-2b3d9c6e1a01', '3fa85f64-5717-4562-b3fc-2c963f66af00', '6fa85f64-5717-4562-b3fc-2c963f66afa0', 5, 'Excellent!', false, NOW() - INTERVAL '10 days'),
                                                                                            ('1c6e2a7c-91f8-4eb3-9c3f-2b3d9c6e1a02', '3fa85f64-5717-4562-b3fc-2c963f66af00', '6fa85f64-5717-4562-b3fc-2c963f66afa1', 4, 'Good class.', false, NOW() - INTERVAL '9 days'),
                                                                                            ('1c6e2a7c-91f8-4eb3-9c3f-2b3d9c6e1a03', '3fa85f64-5717-4562-b3fc-2c963f66af01', '6fa85f64-5717-4562-b3fc-2c963f66afa2', 2, 'Too fast-paced.', true, NOW() - INTERVAL '8 days'),
                                                                                            ('1c6e2a7c-91f8-4eb3-9c3f-2b3d9c6e1a04', '3fa85f64-5717-4562-b3fc-2c963f66af01', '6fa85f64-5717-4562-b3fc-2c963f66afa3', 3, 'Interesting.', false, NOW() - INTERVAL '7 days'),
                                                                                            ('1c6e2a7c-91f8-4eb3-9c3f-2b3d9c6e1a05', '3fa85f64-5717-4562-b3fc-2c963f66af02', '6fa85f64-5717-4562-b3fc-2c963f66afa4', 1, 'Needs improvement.', true, NOW() - INTERVAL '6 days'),
                                                                                            ('1c6e2a7c-91f8-4eb3-9c3f-2b3d9c6e1a06', '3fa85f64-5717-4562-b3fc-2c963f66af02', '6fa85f64-5717-4562-b3fc-2c963f66afa5', 5, 'Loved it!', false, NOW() - INTERVAL '5 days'),
                                                                                            ('1c6e2a7c-91f8-4eb3-9c3f-2b3d9c6e1a07', '3fa85f64-5717-4562-b3fc-2c963f66af03', '6fa85f64-5717-4562-b3fc-2c963f66afa6', 2, 'Confusing topic.', true, NOW() - INTERVAL '4 days'),
                                                                                            ('1c6e2a7c-91f8-4eb3-9c3f-2b3d9c6e1a08', '3fa85f64-5717-4562-b3fc-2c963f66af03', '6fa85f64-5717-4562-b3fc-2c963f66afa7', 3, 'Average.', false, NOW() - INTERVAL '3 days'),
                                                                                            ('1c6e2a7c-91f8-4eb3-9c3f-2b3d9c6e1a09', '3fa85f64-5717-4562-b3fc-2c963f66af04', '6fa85f64-5717-4562-b3fc-2c963f66afa8', 1, 'Not enough material.', true, NOW() - INTERVAL '2 days'),
                                                                                            ('1c6e2a7c-91f8-4eb3-9c3f-2b3d9c6e1a10', '3fa85f64-5717-4562-b3fc-2c963f66af04', '6fa85f64-5717-4562-b3fc-2c963f66afa9', 4, 'Well structured.', false, NOW() - INTERVAL '1 day');