# Merge Adapters

## What is `MergeAdapter` ?
`MergeAdapter` reduces the friction when you want to "merge" multiple adapters "sequentially" within a `RecyclerView`. 
To make handling multiple feed item types whilst still maintaining clean abstractions between them in code, Google recently announced `MergeAdapter`, a new class available in `RecyclerView` version `1.2.0-alpha02` onwards.

<img src="https://user-images.githubusercontent.com/10084360/103627540-9f80c280-4ef2-11eb-9527-cf289597af99.jpeg" width="1000px" height="450px" />

## Dependencies
```
  implementation 'androidx.recyclerview:recyclerview:1.2.0-alpha02'
  implementation 'com.github.bumptech.glide:glide:4.8.0'
  annotationProcessor 'com.github.bumptech.glide:compiler:4.8.0'
```

## Implementing `MergeAdapter`
```
  val mergeAdapter: MergeAdapter = MergeAdapter(customAdapter, customAdapterRe)
  my_recycler_view.adapter = mergeAdapter
```

## Demo
<img src="https://user-images.githubusercontent.com/10084360/103627283-4153df80-4ef2-11eb-9ad4-b53871fb0cb9.png" width="350px" height="650px" />
