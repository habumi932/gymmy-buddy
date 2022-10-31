package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Category type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Categories", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ }),
  @AuthRule(allow = AuthStrategy.PRIVATE, operations = { ModelOperation.READ })
})
public final class Category implements Model {
  public static final QueryField ID = field("Category", "id");
  public static final QueryField CATEGORY_NAME = field("Category", "category_name");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String category_name;
  private final @ModelField(targetType="ExerciseCategory") @HasMany(associatedWith = "category", type = ExerciseCategory.class) List<ExerciseCategory> exercises = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getCategoryName() {
      return category_name;
  }
  
  public List<ExerciseCategory> getExercises() {
      return exercises;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Category(String id, String category_name) {
    this.id = id;
    this.category_name = category_name;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Category category = (Category) obj;
      return ObjectsCompat.equals(getId(), category.getId()) &&
              ObjectsCompat.equals(getCategoryName(), category.getCategoryName()) &&
              ObjectsCompat.equals(getCreatedAt(), category.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), category.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getCategoryName())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Category {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("category_name=" + String.valueOf(getCategoryName()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
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
  public static Category justId(String id) {
    return new Category(
      id,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      category_name);
  }
  public interface BuildStep {
    Category build();
    BuildStep id(String id);
    BuildStep categoryName(String categoryName);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String category_name;
    @Override
     public Category build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Category(
          id,
          category_name);
    }
    
    @Override
     public BuildStep categoryName(String categoryName) {
        this.category_name = categoryName;
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
    private CopyOfBuilder(String id, String categoryName) {
      super.id(id);
      super.categoryName(categoryName);
    }
    
    @Override
     public CopyOfBuilder categoryName(String categoryName) {
      return (CopyOfBuilder) super.categoryName(categoryName);
    }
  }
  
}
