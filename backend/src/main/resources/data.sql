INSERT INTO tb_user (name, email, password) VALUES ('User', 'user@mapin.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Admin', 'admin@mapin.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_categoria (titulo, cor) VALUES 
('LIVRE', 'white');

INSERT INTO tb_categoria (titulo, cor) VALUES 
('MÚSICAS', 'red');

INSERT INTO tb_categoria (titulo, cor) VALUES 
('DOCUMENTÁRIOS', 'black');

INSERT INTO tb_categoria (titulo, cor) VALUES 
('ESPORTES', 'orange');

INSERT INTO tb_categoria (titulo, cor) VALUES 
('YDELETE', 'brown');

INSERT INTO tb_video (titulo, descricao, url, categoria_id) VALUES 
('A Guerra Franco-Prussiana', 'A Guerra Franco-Prussiana e a Unificação da Alemanha', 
'https://www.youtube.com/watch?v=QLuYGxJzNlE&t=242s', 1);

INSERT INTO tb_video (titulo, descricao, url, categoria_id) VALUES 
('Built By Nations', 'Greta Van Fleet - Built By Nations (Audio)', 
'https://www.youtube.com/watch?v=EsI1ujh65u0', 2);

INSERT INTO tb_video (titulo, descricao, url, categoria_id) VALUES 
('Lovers On The Sun', 'David Guetta - Lovers On The Sun (Official Video) ft Sam Martin', 
'https://www.youtube.com/watch?v=BPiW0tkWfeg', 2);

INSERT INTO tb_video (titulo, descricao, url, categoria_id) VALUES 
('Musashi', 'Musashi, o maior samurai | Nerdologia', 
'https://www.youtube.com/watch?v=gRe7oBX7LYk', 3);

INSERT INTO tb_video (titulo, descricao, url, categoria_id) VALUES 
('As 7 Maravilhas - Mundo Antigo', 'As 7 Maravilhas do Mundo Antigo - O Colossol, O Farol, Os Templos e Piramides - Foca na História', 
'https://www.youtube.com/watch?v=afIat9PtJVk', 3);

INSERT INTO tb_video (titulo, descricao, url, categoria_id) VALUES 
('Brasil x EUA Pan (1987)', 'Jogos Pan-Americanos de Basquete (1987) - Brasil x EUA', 
'https://www.youtube.com/watch?v=Gsxvhia50No&t=4186s', 4);

INSERT INTO tb_video (titulo, descricao, url, categoria_id) VALUES 
('Atlanta 1996 - Prata G. Borges', 'Gustavo Borges - Prata 200 Livre - Atlanta 1996', 
'https://www.youtube.com/watch?v=VI0GendBIZo', 4);

