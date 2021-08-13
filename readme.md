This is a very sample project for learning purpose of Graphql 

1. Run the application 
   1. below are the post man config :
      POST -> http://localhost:8181/graphql
       QUERY - >
      query getBooks{
          getBooks{
             id
             name            
             pages
          }
      }
        
   2. Scenario 2 
       POST -> http://localhost:8181/graphql
       Query ->
      query getBook($id : Int){
           getBook(id : $id){
              name
              pages
           }
      }

      Parameter ->
      {
      "id": "100"
      }
        