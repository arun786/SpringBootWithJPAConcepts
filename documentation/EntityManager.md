# Entity Manager

To use Entity Manager, the below steps are used.

    1. Declare the class with the below.
        @Transactional
    2. Autowire the Entity Manager with 
        @PersistenceContext
        private EntityManager entityManager.
        
## to save an entity
    
    entityManager.persist(<Object to be persisted>)

## to update an entity
    
    entityManager.merge(<object to be persisted>)
 
## to find based on Id

    enitytManager.find(class, id)
    
## to delete an entity

    entityManager.delete(<Object to be deleted>)