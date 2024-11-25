## 1. Introduction to `null`
- Overview of `null` as a value to indicate no data.
- Importance of handling absence of value in Kotlin.

## 2. Declaring Variables in Kotlin
- Variables require initialization.
- Default non-nullable type in Kotlin.

### Example:
```kotlin
val favoriteActor = "Sandra Oh"
```

## 3. Using `null` in Kotlin
- Explicitly declare a nullable variable using `?`.

### Example:
```kotlin 
var favoriteActor: String? = null
```

## 4. Handling Nullable Types
- Accessing nullable types with `?.` (safe call operator).
- Syntax:
```kotlin 
favoriteActor?.let {
	println("Favorite actor is $it") 
}
```

# Handling null in Kotlin

## 5. Reassigning Variables to null

You can reassign nullable variables to null.
### Example:
```kotlin 
var favoriteActor: String? = "Sandra Oh" 
favoriteActor = null
```

## 6. Non-Nullable vs Nullable Types

Nullable (`String?`) vs non-nullable (`String`).
Error if assigning null to a non-nullable type.
### Example:
```kotlin
var actorName: String = "Sandra Oh"
// actorName = null // Error: Null cannot be assigned
```

## 7. Working with Nullable Variables

Nullable variables require special handling to avoid null pointer exceptions.
### Example:
```kotlin
var favoriteActor: String? = "Sandra Oh"
favoriteActor = null
println(favoriteActor) // Outputs: null
```

## 8. Conclusion
- Importance of using nullable types cautiously.
- Use nullable types when necessary and avoid null for better safety.
