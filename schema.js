db = db.getSiblingDB('4movies');


db.createCollection("videos");

db.videos.insertMany([
  {
    "titulo": "Video 1",
    "descricao": "Descrição do Video 1",
    "url": "url_video_1",
    "dataPublicacao": "2023-01-01",
    "categorias": ["Categoria1"],
    "visualizacoes": 100
  },
  {
    "titulo": "Video 2",
    "descricao": "Descrição do Video 2",
    "url": "url_video_2",
    "dataPublicacao": "2023-02-01",
    "categorias": ["Categoria2"],
    "visualizacoes": 50
  }
]);

db.createCollection("usuarios");

db.usuarios.insertMany([
    {
      "nome": "Usuario1",
      "email": "usuario1@example.com",
      "favoritos": ["ID_Video1"]
    },
    {
      "nome": "Usuario2",
      "email": "usuario2@example.com",
      "favoritos": ["ID_Video2"]
    }
  ]);
 
db.createCollection("categorias");

  // Inserir dados na coleção de categorias
  db.categorias.insertMany([
    {
      "nome": "Categoria1",
      "descricao": "Descrição da Categoria1"
    },
    {
      "nome": "Categoria2",
      "descricao": "Descrição da Categoria2"
    }
  ]);  
