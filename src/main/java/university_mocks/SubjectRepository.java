package university_mocks;

public interface SubjectRepository {

    Subject findSubject();
    default boolean isTrue() {
        return true;
    }
}
