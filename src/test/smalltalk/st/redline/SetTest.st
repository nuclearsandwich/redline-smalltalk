TestCase < #SetTest

- test
  self testNewProducesASet.
  " self testNewWithArgProducesASet. TODO: Pending implementation question. "
  self testAtRaisesError.
  self testAtPutRaisesError.
  self testAddPutsElementInSet.
  self testAddOnlyWorksWithUniqueObjects.
  self testSizeOfEmptySetIsZero.
  self testSizeIncreasesWhenElementsAdded.
  self testSizeDoesNotIncreaseIfDuplicateAdded.
  self testIncludesReturnsTrueWhenItemFoundInSet.
  self testIncludesReturnsFalseWhenItemNotFoundInSet.
  self testOccurencesOfIsAlwaysOne.

- testNewProducesASet
  | aSet |

  aSet := Set new.
  self assert: aSet class equals: Set withMessage: 'Set instance not created.'.

" TODO: Determine if Collection#new:  will be implemented.
- testNewWithArgProducesASet
  | aSet |

  aSet := Set new: 2.

  self assert: aSet class equals: Set withMessage: 'Set instance not created.'.
"

" Pending implementation "

- testAtRaisesError

- testAtPutRaisesError


- testAddPutsElementInSet

- testAddOnlyWorksWithUniqueObjects

- testSizeOfEmptySetIsZero

- testSizeIncreasesWhenElementsAdded

- testSizeDoesNotIncreaseIfDuplicateAdded

- testIncludesReturnsTrueWhenItemFoundInSet

- testIncludesReturnsFalseWhenItemNotFoundInSet

- testOccurencesOfIsAlwaysOne
