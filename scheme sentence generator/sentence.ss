(define nouns '(dog book HarryPotter homework science twilight chess coffee computers stuy facebook yankees elmo birds flag television PresidentBush pretzels hockey Mr.DW LadyGaga arithmetic approval arch afterthought acoustics advertisement badge banana bubble boundary cushion crib current committee cobweb degree digestion donkey duck eye eggnog earthquake error fairies flock feet flowers fly furniture geese governor guitar grandmother hydrant houses humor hobbies history hammer island idea insect insurance jellybeans jam jewel jellyfish journey jeans knot kettle kitty knee lady lunch lumber leather mice mitten mother morning music nation north needle oatmeal owl oven onion paint pizza pipe potato protest quarter quicksand quartz quiver receipt representative religion robin spider scissors scarecrow society sponge substance system stomach sidewalk texture tiger toothbrush tongue tomatoes turkey umbrella uncle vacation vase vegetable visitor volleyball volcano wax whistle wish wren wench writer yam yak yacht yarn zebra zoo zipper zephyr))

(define adjectives '(pretty big hairy boring hated teenage blue calm gentle mesmerizing amazing small beautiful ugly stinky radiant funny white computational supercalifragilisticexpialidocious adhesive adaptable abundant abusive breakable brainy brave charming chilly clean classy different descriptive daily eager educated epic entertaining faithful fierce flawless fragrant goofy glorious grotesque hospitable hypnotic husky intelligent incandescent imminent judicious jittery juvenile kaput keen knowledgeable lopsided luxuriant ludicrous lucky loutish lackadaisical materialistic miscreant murky naive nauseating nondescript nonchalant nippy omniscient overwrought oafish obsequious ossified paltry picayune psychedelic quaint quixotic quirky rhetorical recondite rambunctious ruddy scintillating savory stupendous sordid swanky sweltering sophisticated truculent therapeutic tacit tawdry taboo ubiquitous utopian uppity vagabond volatile voracious waggish woozy woebegone wry wiggly yielding yummy youthful zany zealous zonked))

(define verbs '(runs jumps goes pokes smacks gives is tricks eats reads does hates fails summarizes asks speaks loves sighs sews sings harmonizes admires applauds appreciates avoids buries breathes coughs calculates misunderstands challenges dreams divides extends explains fires frightens falls forces grins guides guarantees hops hurries hugs invites irritates jails jokes joins kisses knocks listens looks misses moves marries notices nods names objects offends owes obtains packs pours prays pretends reduces rushes retires squeaks slaps scratches tickles tumbles twists types unpacks uses unlocks vanishes visits waits walks wastes whispers worries yawns yells zips))

(define articles '(a an the a the))

(define nth
  (lambda (n g)
    (if (= n 1)
        (car g)
        (nth (- n 1)(cdr g)))))

(define one-of
  (lambda (k)
    (nth (+ 1 (random (length k))) k)))

(define noun
  (lambda ()
    (list (one-of nouns))))

(define verb
  (lambda ()
    (list (one-of verbs))))

(define adjective
  (lambda ()
    (list (one-of adjectives))))

(define article
  (lambda ()
    (list (one-of articles))))

(define article?
  (lambda ()
    (if (= (random 3) 0)
        '()
        (article))))

(define adjective*
  (lambda ()
    (if (= (random 2) 0)
        '()
        (append (adjective)(adjective*)))))

(define noun-phrase
  (lambda ()
    (append (article?)(adjective*)(noun))))

(define noun-phrase?
  (lambda ()
    (if (= (random 2) 0)
        '()
        (append (article?)(adjective*)(noun)))))

(define sentence
  (lambda ()
    (append (noun-phrase)(verb)(noun-phrase?))))