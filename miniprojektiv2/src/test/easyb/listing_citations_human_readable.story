import com.ohtu.miniprojektiv2.*;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description 'user can list citations in human readable form'

scenario "user can list added citations", {
    given 'add new citation selected with correct entries';
    when 'citation adding has succeeded';
    then 'user can see added citation';
}
scenario "user can list empty list of citation", {
    given 'front page selected';
    when 'no citations are added';
    then 'user can not see any citations listed';
}