package entity;

/**
 * @createTime:2021/03/28 22:57
 * @author:luofeng30850
 */
public class Class {
    private int classId;

    private String className;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Class{");
        sb.append("classId=").append(classId);
        sb.append(", className='").append(className).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
