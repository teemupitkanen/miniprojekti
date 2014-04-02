import com.ohtu.miniprojektiv2.*;


description 'user can add inproceedings citation'

scenario "user can add inproceedings citation with correct entries", {
    given 'add new citation selected';
    when 'valid citation entries are given';
    then 'user can add new citation';
}

scenario "user can add inproceedings citation with correct extra entries", {
    given 'add new citation selected';
    when 'valid citation entries with correct extra entries are given';
    then 'user can add new citation';
}

scenario "user can not add inproceedins citation with incorrect year", {
    given 'add new citation selected';
    when 'incorrect year and other correct entries are given';
    then 'user can not add citation';
}

scenario "user can not add inproceedins citation with empty entries", {
    given 'add new citation selected';
    when 'no entries are given';
    then 'user can not add citation';
}