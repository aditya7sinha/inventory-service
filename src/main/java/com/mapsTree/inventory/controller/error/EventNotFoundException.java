package com.mapsTree.inventory.controller.error;



public class EventNotFoundException extends NotFoundException {
        public EventNotFoundException(String eventId){
                super(ErrorConstants.EVENT_ID_NOT_FOUND_CODE,
                        ErrorConstants.EVENT_ID_NOT_FOUND_REASON,
                        String.format(ErrorConstants.EVENT_ID_NOT_FOUND_MESSAGE,eventId));
        }

}
