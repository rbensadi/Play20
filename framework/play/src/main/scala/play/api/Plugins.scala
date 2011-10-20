package play.api

import play.api.mvc._

/**
 * A Play plugin.
 *
 * You can define a Play plugin this way:
 * {{{
 * class MyPlugin(app: Application) extends Plugin
 * }}}
 *
 * The plugin class must be declared in a play.plugins file available in the classpath root:
 * {{{
 * myapp.MyPlugin:1000
 * }}}
 * The associated int defines the plugin priority.
 */
trait Plugin {

  /**
   * Called when the application starts.
   */
  def onStart {}

  /**
   * Called when the application stops.
   */
  def onStop {}

}

/**
 * Global plugin executes application's globalSettings onStart and onStop.
 */
class GlobalPlugin(app: Application) extends Plugin {
  /**
   * Called when the application starts.
   */
  override def onStart {
    app.global.onStart(app)
  }

  /**
   * Called when the application stops.
   */
  override def onStop {
    app.global.onStop(app)
  }
}
