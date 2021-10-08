# SkeletonSDUI #Skeleton Server Driven User Interface
The main idea here is to show a simple Server Driver User Interface implemented by me without watch any other examples. 

Lets talk about what is what in this code and why I should implement a solution of this like this.

First,

We will start from MainActivity.kt class and call a 

```
viewModel.getSDUIcomponents()
```

to get what we want to show on our view.

After that, inside in viewmodel, you will see a NetworkFake, who will create a ComponentResponse.kt class just to show how it is going to happen
when we do the call to the rights service Rest API.

```
NetworkFake().getSDUIcomponents()
```

After that, we will create a SDUIController(I'm not using DI because you can use whatever you want to use here, Koin, Hilt, Dagger, it is not the point in this reposiroy)

```
SDUIController().createComponents(componentResponse)
```

So after that, inside of createComponents you will see a code to transform our Response Backend Service to our Mobile World.

```
for (element in components) {
   list.add(creator.createComponent(element))
}

```

After we created our components, you will see it is easy to put new components in createComponent:

```
fun createComponent(clazz: ComponentResponse): Component {
        return when (clazz.typeComponentResponse) {
            TEXTVIEW -> {
                TextView()
            }
            EDITTEXT -> {
                EditText()
            }
            PICKER -> {
                Picker()
            }
            else -> {
                TextView()
            }
        }
    }
```
(Just add another type of your cool component and dont worry about anything, events and validations will check later)

So with this, we have our mapper from backend to mobile. Now, let go to the MainActivity.kt class again and see the answer here

```
result = viewModel.getSDUIcomponents()
```

Here we have our answer, let put in our SDUIViewController.kt class,

our 

### SDUIViewController 

will have the controll to create the view and put our components inside. So we need to do 2 things here,

1 - set result of components
2 - set Listener to what we want, here I just want to validate if every component is valid.

Now, going a little deep, let go to the SDUIViewController to see what is inside, you will see I created a CustomView with ConstraintLayout as parent.

When we init this class, this method will call first

```
init {
   removeView(this)
   configureRootLayout()
}
```

And after we loaded the data from backend, we will call setupView as mentioned before.
The code is here,

```
    fun setupView(listComponent: List<Component>, actionListener: Listener) {
        listComponentSavedInMemory = listComponent
        rootLayout.addView(configureScrollView(rootLayout))

        val linearLayout = LinearLayout(context)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.gravity = Gravity.CENTER

        setComponentsInsideLinearLayout(actionListener, linearLayout)

        scrollView.addView(linearLayout)
    }
```

What I did is to create a configuration from a Scrollview just to safe if we have more itens is viewed in our app and we need this kind of actions and
set a LinearLayout to put our components inside, calling this method **setComponentsInsideLinearLayout**

Here we will do

```
for (element in listComponentSavedInMemory) {
            element.setObserableAction(actionListener)
            linearLayout.addView(element.getView(context))
        }
```

And if you check it out, all of our views will need to extend **Component**

That is because we will need to do this trick in every view

```
 open fun getView(context: Context): View = View(context)

 open fun setObserableAction(action: Listener) {}
```

First to get our CustomView and second to collect action when triggered.

And finally, we will need to implement a Validator class in our viewers because we want to know when is ok and this will be collected after to enable our continue button screen.

```
interface Validator {
    fun isValid() : Boolean
}
```

if you look EditText you will see

```
override fun isValid(): Boolean = editText.text.isNotEmpty()
```

and inside again in EditText

```
override fun setObserableAction(action: Listener) {
        actionListener = action
    }
```

So in the end of this, if you go back to MainActivity.kt you will see at the end of file:

```
 private fun onItemChangedMainActivity() {
        if (binding.sduiView.validateComponents()) {
            binding.btnOutside.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
        } else {
            binding.btnOutside.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        }
    }
```

Just to show how it work, when EditText changed validateComponents will check if everyone is valid to validate our **btnOutside** is enabled or not.

```
  fun validateComponents(): Boolean {
        val result = listComponentSavedInMemory.filter { !it.isValid() }

        return result.isEmpty()
    }
```

So, here is a demo show how it working.

![image demo](https://imgur.com/9xHSq08.jpg)
