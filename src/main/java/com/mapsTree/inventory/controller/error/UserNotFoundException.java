package com.mapsTree.inventory.controller.error;

public class UserNotFoundException extends NotFoundException{
    public UserNotFoundException(String userId) {
        super(ErrorConstants.USER_ID_NOT_FOUND_CODE, ErrorConstants.USER_ID_NOT_FOUND_REASON,
                String.format(ErrorConstants.USER_ID_NOT_FOUND_MESSAGE, userId));
    }
}
