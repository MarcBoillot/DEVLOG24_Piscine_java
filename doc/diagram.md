# CANDIDATE CLASS
1. This is the candidate complete candidate class for the pool project
```mermaid
classDiagram
    class Candidate
    Candidate : +String firstname
    Candidate : +String lastname
    Candidate : +String email
    Candidate : +Picture picture
    
    class CandidateController
    CandidateController : +getAllCandidate()
    CandidateController : +createCandidate(Candidate candidate)
    CandidateController : +removeCandidate(Candidate candidate)
    CandidateController : +modifyCandidat(Candidate candidate)
    
    class CandidateServices
    CandidateServices : +findAll()
    CandidateServices: +findById(int id)
    CandidateServices: +save(Candodate candidate)
    CandidateServices: +delete(Candidate candidate)
    CandidateServices: +update(Candidate candidate)

    class CrudRepository
    <<interface>> CrudRepository
    CrudRepository : +findAll()
    CrudRepository: +findById(int id)
    CrudRepository: +save(Candodate candidate)
    CrudRepository: +delete(Candidate candidate)
    CrudRepository: +update(Candidate candidate)
    
    class CandidateRepository
    CandidateRepository : +findAll()
    CandidateRepository: +findById(int id)
    CandidateRepository: +save(Candodate candidate)
    CandidateRepository: +delete(Candidate candidate)
    CandidateRepository: +update(Candidate candidate)
    
```
# OBSERVER CLASS
- It's the complete Observer class for project
```mermaid
classDiagram
    class observer
    observer : +int id
    observer : +String lastname
    observer : +String firstname
    observer : +String society
    observer : +String email
    
    class ObserverController
    ObserverController: +createObserver(Observer observer)
    ObserverController: +getObserverById(int id)
    ObserverController: +getAllObserver()
    ObserverController: +updateObserver(int id, Observer observer)
    ObserverController: +deleteObserver(int id)
    
    class ObserverService
    ObserverService: +createObserver(Observer observer)
    ObserverService: +getObserverById(int id)
    ObserverService: +getAllObserver()
    ObserverService: +updateObserver(int id, Observer observer)
    ObserverService: +deleteObserver(int id)

    class ObserverRepository
    ObserverRepository : +findAll()
    ObserverRepository: +findById(int id)
    ObserverRepository: +save(Observer observer)
    ObserverRepository: +delete(Candidate observer)
    ObserverRepository: +update(Observer observer)

    class CrudRepository
    <<interface>> CrudRepository
    CrudRepository : +findAll()
    CrudRepository: +findById(int id)
    CrudRepository: +save(Observer observer)
    CrudRepository: +delete(Observer observer)
    CrudRepository: +update(Observer observer)

```
# Pools class
```mermaid

classDiagram
class pools
pools : +int id
pools : +String name
pools  : +String town
pools  : +Date date

    class PoolsController
    PoolsController : +createPool()
    PoolsController : +getPools()
    PoolsController : +getPoolsById(id)
    PoolsController : +updatePool(Pools, pool)
    PoolsController : +deletePool(id)
    
    class poolsServices
    poolsServices : +createPool(Pools pool)
    poolsServices: +getPoolsById(int id)
    poolsServices: +getPools()
    poolsServices: +delete(pool)
    poolsServices: +update(pools pool)
    
    class poolsRepository
    <<interface>> poolsRepository
    poolsRepository : extends CrudRepository
```

# CATEGORY CLASS
- It's the complete Category class for project
```mermaid
classDiagram
    class Category
    Category : +int id
    Category : +String title
    Category : +String description
    
    class CategoryController
    CategoryController: +createCategory(Category category)
    CategoryController: +getCategoryById(int id)
    CategoryController: +getAllCategory()
    CategoryController: +updateCategory(int id, Category category)
    CategoryController: +deleteCategory(int id)
    
    class CategoryService
    CategoryService: +createCategory(Category category)
    CategoryService: +getCategoryById(int id)
    CategoryService: +getAllCategory()
    CategoryService: +updateCategory(int id, Category category)
    CategoryService: +deleteCategory(int id)

    class CategoryRepository
    CategoryRepository : +findAll()
    CategoryRepository: +findById(int id)
    CategoryRepository: +save(Category category)
    CategoryRepository: +delete(Category category)
    CategoryRepository: +update(Category category)

    class CrudRepository
    <<interface>> CrudRepository
    CrudRepository : +findAll()
    CrudRepository: +findById(int id)
    CrudRepository: +save(Category category)
    CrudRepository: +delete(Category category)
    CrudRepository: +update(Category category)
```

# CRITERIA ENTITIES
- It's the complete Criteria class for project
```mermaid
classDiagram
    class Criteria
    Criteria : +int id
    Criteria : +String title
    Criteria : +String description
    
    class CriteriaController
    CriteriaController: +createCriteria(Criteria riteria)
    CriteriaController: +getCriteriaById(int id)
    CriteriaController: +getAllCriteria()
    CriteriaController: +updateCriteria(int id, Criteria criteria)
    CriteriaController: +deleteCriteria(int id)
    
    class CriteriaService
    CriteriaService: +createCriteria(Criteria criteria)
    CriteriaService: +getCriteriaById(int id)
    CriteriaService: +getAllCriteria()
    CriteriaService: +updateCriteria(int id, Criteria criteria)
    CriteriaService: +deleteCriteria(int id)

    class CriteriaRepository
    CriteriaRepository : +findAll()
    CriteriaRepository: +findById(int id)
    CriteriaRepository: +save(Criteria criteria)
    CriteriaRepository: +delete(Criteria criteria)
    CriteriaRepository: +update(Criteria criteria)

    class CrudRepository
    <<interface>> CrudRepository
    CrudRepository : +findAll()
    CrudRepository: +findById(int id)
    CrudRepository: +save(Criteria criteria)
    CrudRepository: +delete(Criteria criteria)
    CrudRepository: +update(Criteria criteria)
```