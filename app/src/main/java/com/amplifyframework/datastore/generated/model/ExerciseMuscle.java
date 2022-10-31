package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the ExerciseMuscle type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "ExerciseMuscles")
@Index(name = "byMuscle", fields = {"muscleID"})
@Index(name = "byExercise", fields = {"exerciseID"})
public final class ExerciseMuscle implements Model {
  public static final QueryField ID = field("ExerciseMuscle", "id");
  public static final QueryField MUSCLE = field("ExerciseMuscle", "muscleID");
  public static final QueryField EXERCISE = field("ExerciseMuscle", "exerciseID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Muscle", isRequired = true) @BelongsTo(targetName = "muscleID", type = Muscle.class) Muscle muscle;
  private final @ModelField(targetType="Exercise", isRequired = true) @BelongsTo(targetName = "exerciseID", type = Exercise.class) Exercise exercise;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public Muscle getMuscle() {
      return muscle;
  }
  
  public Exercise getExercise() {
      return exercise;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private ExerciseMuscle(String id, Muscle muscle, Exercise exercise) {
    this.id = id;
    this.muscle = muscle;
    this.exercise = exercise;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      ExerciseMuscle exerciseMuscle = (ExerciseMuscle) obj;
      return ObjectsCompat.equals(getId(), exerciseMuscle.getId()) &&
              ObjectsCompat.equals(getMuscle(), exerciseMuscle.getMuscle()) &&
              ObjectsCompat.equals(getExercise(), exerciseMuscle.getExercise()) &&
              ObjectsCompat.equals(getCreatedAt(), exerciseMuscle.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), exerciseMuscle.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getMuscle())
      .append(getExercise())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("ExerciseMuscle {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("muscle=" + String.valueOf(getMuscle()) + ", ")
      .append("exercise=" + String.valueOf(getExercise()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static MuscleStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static ExerciseMuscle justId(String id) {
    return new ExerciseMuscle(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      muscle,
      exercise);
  }
  public interface MuscleStep {
    ExerciseStep muscle(Muscle muscle);
  }
  

  public interface ExerciseStep {
    BuildStep exercise(Exercise exercise);
  }
  

  public interface BuildStep {
    ExerciseMuscle build();
    BuildStep id(String id);
  }
  

  public static class Builder implements MuscleStep, ExerciseStep, BuildStep {
    private String id;
    private Muscle muscle;
    private Exercise exercise;
    @Override
     public ExerciseMuscle build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new ExerciseMuscle(
          id,
          muscle,
          exercise);
    }
    
    @Override
     public ExerciseStep muscle(Muscle muscle) {
        Objects.requireNonNull(muscle);
        this.muscle = muscle;
        return this;
    }
    
    @Override
     public BuildStep exercise(Exercise exercise) {
        Objects.requireNonNull(exercise);
        this.exercise = exercise;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, Muscle muscle, Exercise exercise) {
      super.id(id);
      super.muscle(muscle)
        .exercise(exercise);
    }
    
    @Override
     public CopyOfBuilder muscle(Muscle muscle) {
      return (CopyOfBuilder) super.muscle(muscle);
    }
    
    @Override
     public CopyOfBuilder exercise(Exercise exercise) {
      return (CopyOfBuilder) super.exercise(exercise);
    }
  }
  
}
