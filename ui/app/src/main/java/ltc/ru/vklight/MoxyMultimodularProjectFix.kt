package ltc.ru.vklight

import com.arellomobile.mvp.RegisterMoxyReflectorPackages



// In order to generate code for a multi-modular project moxy needs to be told when
// and where to generate a MoxyReflector class which must be created separately for each module.
// To tell it this we must in each ui submodule's build.gradle add these lines:
// (Note: If you apply base_ui_submodule_config script this is done automatically)
// kapt {
//    arguments {
//        arg("moxyReflectorPackage", "ru.ltc.taskhelper.name_of_current_ui_submodule")
//    }
// }
// And add the specified package name inside this annotation's arguments list.
@RegisterMoxyReflectorPackages(
    "ltc.ru.vklight.authorization",
    "ltc.ru.vklight.feed"
    )
class MoxyMultimodularProjectFix