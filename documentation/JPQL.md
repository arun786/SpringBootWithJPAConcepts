# JPQL

## if want to select all the elements of the table, using entity

    @Override
    public List<CourseEntity> findAllCourseusingJpql() {
        TypedQuery<CourseEntity> typedCourses = entityManager.createQuery("select c from CourseEntity c", CourseEntity.class);
        return typedCourses.getResultList();
    }