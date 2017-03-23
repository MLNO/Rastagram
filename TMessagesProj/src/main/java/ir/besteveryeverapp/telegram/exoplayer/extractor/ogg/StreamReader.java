package ir.besteveryeverapp.telegram.exoplayer.extractor.ogg;

import java.io.IOException;

import ir.besteveryeverapp.telegram.exoplayer.extractor.Extractor;
import ir.besteveryeverapp.telegram.exoplayer.extractor.ExtractorInput;
import ir.besteveryeverapp.telegram.exoplayer.extractor.ExtractorOutput;
import ir.besteveryeverapp.telegram.exoplayer.extractor.PositionHolder;
import ir.besteveryeverapp.telegram.exoplayer.extractor.TrackOutput;
import ir.besteveryeverapp.telegram.exoplayer.util.ParsableByteArray;

/**
 * StreamReader abstract class.
 */
/* package */ abstract class StreamReader {

  protected final ParsableByteArray scratch = new ParsableByteArray(
      new byte[OggParser.OGG_MAX_SEGMENT_SIZE * 255], 0);

  protected final OggParser oggParser = new OggParser();

  protected TrackOutput trackOutput;

  protected ExtractorOutput extractorOutput;

  void init(ExtractorOutput output, TrackOutput trackOutput) {
    this.extractorOutput = output;
    this.trackOutput = trackOutput;
  }

  /**
   * @see Extractor#seek()
   */
  void seek() {
    oggParser.reset();
    scratch.reset();
  }

  /**
   * @see Extractor#read(ExtractorInput, PositionHolder)
   */
  abstract int read(ExtractorInput input, PositionHolder seekPosition)
      throws IOException, InterruptedException;
}
