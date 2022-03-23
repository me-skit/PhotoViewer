
# Photo Viewer

> Basic Android App that shows photos and their title.

This app is an exercise that retrieves photos using an HTTP Get request using Retrofit and Room, shows the photos in a RecyclerView, has the option to tap a photo title, and then show the original size photo.

![Screenshot](./screenshot.png)

## Built With

- Kotlin
- Android Studio

## Getting Started

Get a local copy running the following command.

`git clone git@gitlab.com:meme_es/PhotoViewer.git`

### Prerequisites

- Android Studio

### Usage

Open the project using Android Studio, select an Android Virtual Device (AVD), press the run triangle(Run) button or just press shift-10, and let the IDE make the rest.

The main activity shows the list of photos retriever from `https://jsonplaceholder.typicode.com/photos` if you tap on the title of one photo a new activity is launched to show the original size picture.

![Screenshot2](./screenshot-info.png)

## Authors

👤 **Meme**

- GitLab: [@meme_es](https://gitlab.com/meme_es)
- Linkedin: [linkedin](https://www.linkedin.com/in/manuel-elias/)

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

Feel free to check the [issues page](https://gitlab.com/meme_es/PhotoViewer/-/issues).

## Show your support

Give a ⭐️ if you like this project!


## 📝 License

This project is unlicensed.
