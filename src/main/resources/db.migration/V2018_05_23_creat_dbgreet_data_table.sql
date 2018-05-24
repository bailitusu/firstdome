CREATE TABLE demo_data (
  id          SERIAL  NOT NULL,
  title       VARCHAR(200)           NOT NULL,
  description VARCHAR(500)           NOT NULL,
  CONSTRAINT pk_demo_data_id PRIMARY KEY (id),
  CONSTRAINT uk_demo_data_title UNIQUE (title)
);