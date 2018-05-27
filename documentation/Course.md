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
