# Course 

## Create Entity

    @Override
    public CourseEntity createACourse(CourseEntity courseEntity) {
        return entityManager.merge(courseEntity);
    }