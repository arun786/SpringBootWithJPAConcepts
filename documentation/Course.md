# Course 

## Create Entity

    @Override
    public CourseEntity createACourse(CourseEntity courseEntity) {
        return entityManager.merge(courseEntity);
    }
    
## Find an Entity

    @Override
    public CourseEntity findById(long id) {
        CourseEntity course = entityManager.find(CourseEntity.class, id);
        if (null == course) {
            throw new DataNotFoundException(Constants.NO_DATA_NOT_FOUND);
        }
        return course;
    }

## Delete an Entity

    /**
     * Delete @Transactional is required
     *
     * @param id
     */
    @Override
    public void deleteById(long id) {
        CourseEntity course = findById(id);
        entityManager.remove(course);
    }

## Update an Entry

    @Override
    public void updateACourse(CourseEntity course) {
       long id = course.getId();
       CourseEntity courseEntity = findById(id);
       courseEntity.setName(course.getName());
       entityManager.merge(courseEntity);
    }
