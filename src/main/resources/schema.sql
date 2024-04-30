CREATE TABLE IF NOT EXISTS todo (
    id SERIAL PRIMARY KEY,
    todo varchar(250) NOT NULL,
    is_complete BOOLEAN DEFAULT false,
    created_at timestamp NOT NULL,
    completed_at timestamp
);

